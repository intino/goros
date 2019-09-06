import React from "react";
import ReactDOM from "react-dom";
import Home from "../pages/Home";
import PushService from "alexandria-ui-elements/src/services/PushService";
import FileService from "alexandria-ui-elements/src/services/FileService";
import TranslatorService from "alexandria-ui-elements/src/services/TranslatorService";
import GoogleApiLoader from "alexandria-ui-elements/src/displays/components/geo/GoogleApiLoader";

var launchApplication = function () {
	var configuration = loadConfiguration();

	window.Application = (function(configuration) {
		var self = {};

		self.configuration = configuration;
		self.services = {
			pushService: PushService,
			fileService: FileService.create(configuration),
			translatorService: TranslatorService.create(configuration)
		};

		return self;
	})(configuration);

	renderApplication();

	function loadConfiguration() {
		return document.configuration;
	}

	function renderApplication() {
		const requireGoogleApi = Application.configuration.googleApiKey != null && Application.configuration.googleApiKey !== "";
		const content = requireGoogleApi ? <GoogleApiLoader onLoad={openPushServices()}><Home/></GoogleApiLoader> : <Home/>;
		const home = document.getElementById("Home");
		if (home) ReactDOM.render(content, home);
		if (!requireGoogleApi) openPushServices();
	}

    function openPushServices() {
        window.setTimeout(() => {
            const configuration = Application.configuration;
            const pushConnections = configuration.pushConnections;
            for (let i=0; i<pushConnections.length; i++) {
                const connection = pushConnections[i].split("_##_");
                PushService.openConnection(connection[0], connection[1]);
            }
        }, 100);
    }

};

launchApplication();