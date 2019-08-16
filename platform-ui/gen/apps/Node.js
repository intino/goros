import React from "react";
import ReactDOM from "react-dom";
import Node from "../pages/Node";
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
		const content = requireGoogleApi ? <GoogleApiLoader onLoad={openPushServices()}><Node/></GoogleApiLoader> : <Node/>;
		const node = document.getElementById("Node");
		if (node) ReactDOM.render(content, node);
		if (!requireGoogleApi) openPushServices();
	}

    function openPushServices() {
        window.setTimeout(() => {
            const configuration = Application.configuration;
            const pushServices = configuration.pushServices;
            for (var i=0; i<pushServices.length; i++)
                PushService.openConnection(pushServices[i]);
        }, 100);
    }

};

launchApplication();