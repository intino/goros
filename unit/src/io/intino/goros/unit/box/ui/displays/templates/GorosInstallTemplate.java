package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.Formatters;
import org.monet.metamodel.Distribution;
import org.monet.metamodel.Project;
import org.monet.space.kernel.Kernel;
import org.monet.space.kernel.agents.AgentFilesystem;
import org.monet.space.kernel.agents.AgentLogger;
import org.monet.space.kernel.components.ComponentDocuments;
import org.monet.space.kernel.components.ComponentFederation;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.constants.Strings;
import org.monet.space.kernel.deployer.DeployLogger;
import org.monet.space.kernel.deployer.DeployerPipeline;
import org.monet.space.kernel.deployer.GlobalData;
import org.monet.space.kernel.model.BusinessUnit;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class GorosInstallTemplate extends AbstractGorosInstallTemplate<UnitBox> {
    private Resource model = null;

    public GorosInstallTemplate(UnitBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        if (BusinessUnit.getInstance().isInstalled()) {
            notifier.redirect(session().browser().baseUrl());
            return;
        }
        box().initSession(session());
        title.value(Formatters.firstUpperCase(box().configuration().name()) + " " + translate("model not defined"));
        description.value(translate("Upload") + " " + Formatters.firstUpperCase(box().configuration().name()) + " " + translate("model by using eclipse IDE or drag and drop here"));
        upload.onExecute(e -> updateModel());
        modelFile.onUploading(e -> {
            model = null;
            upload.readonly(true);
            uploading.visible(true);
        });
        modelFile.onChange(e -> {
            uploading.visible(false);
            this.model = e.value();
            upload.readonly(false);
        });
    }

    private void updateModel() {
        upload.readonly(true);
        if (model == null) return;

        loggingBlock.visible(true);
        logEntries.clear();

        if (!ComponentDocuments.getInstance().ping()) {
            notifyUser(translate("Could not upload distribution. DocService is DOWN."), UserMessage.Type.Error);
            upload.readonly(false);
            return;
        }

        if (!executeDeployer()) {
            notifyUser("Model updated successfully", UserMessage.Type.Success);
            upload.readonly(false);
            return;
        }

        notifier.redirect(session().browser().baseUrl());
    }

    private boolean executeDeployer() {
        try {
            String destination, businessModelZipLocation;
            Kernel kernel = Kernel.getInstance();
            org.monet.space.kernel.configuration.Configuration monetConfiguration = kernel.getConfiguration();
            BusinessUnit businessUnit = BusinessUnit.getInstance();
            File tempModelFile;

            DeployerPipeline pipeline = new DeployerPipeline(new DeployerLogger());

            destination = monetConfiguration.getTempDir() + Strings.BAR45 + UUID.randomUUID().toString();
            businessModelZipLocation = monetConfiguration.getBusinessModelZipLocation();

            kernel.stopApplications();

            tempModelFile = File.createTempFile("mml", ".zip");
            AgentFilesystem.writeFile(tempModelFile, model.stream());

            pipeline.setData(GlobalData.MODEL_ZIP_FILE, tempModelFile);
            pipeline.setData(GlobalData.MODEL_INSTALL_DIRECTORY, monetConfiguration.getBusinessModelDir());
            pipeline.setData(GlobalData.TEMP_DIRECTORY, monetConfiguration.getTempDir());
            pipeline.setData(GlobalData.WORKING_DIRECTORY, destination);
            pipeline.setData(GlobalData.COMPONENT_PERSISTENCE, ComponentPersistence.getInstance());
            pipeline.setData(GlobalData.COMPONENT_FEDERATION, ComponentFederation.getInstance());
            pipeline.setData(GlobalData.COMPONENT_DOCUMENTS, ComponentDocuments.getInstance());
            pipeline.setData(GlobalData.BUSINESS_UNIT, businessUnit);
            pipeline.setData(GlobalData.BUSINESS_MODEL_ZIP_LOCATION, businessModelZipLocation);

            pipeline.process();

            Distribution distribution = businessUnit.getDistribution();
            Project project = businessUnit.getBusinessModel().getProject();
            businessUnit.setLabel(BusinessUnit.getSubTitle(distribution, project));
            businessUnit.save();

            if (BusinessUnit.autoRun() && !BusinessUnit.isRunning())
                businessUnit.run();
        } catch (IOException e) {
            Logger.error(e);
            return false;
        }

        return true;
    }

    private class DeployerLogger implements DeployLogger {
        private AgentLogger logger = AgentLogger.getInstance();

        @Override
        public void info(String message, Object... args) {
            logger.infoInModel(message, args);
            logEntries.add("[INFO] " + String.format(message, args)).color("#2896F3");
        }

        @Override
        public void error(Throwable exception) {
            logger.errorInModel(exception);
        }

        @Override
        public void error(String message, Object... args) {
            String errorMsg = (message != null && args != null) ? String.format(message, args) : message;
            logger.errorInModel(errorMsg, null);
            logEntries.add("[ERROR] " + errorMsg).color("#F44335");
        }

        @Override
        public void debug(String message, Object... args) {
            logger.debugInModel(message, args);
            logEntries.add("[DEBUG] " + String.format(message, args)).color("#F89804");
        }
    }
}