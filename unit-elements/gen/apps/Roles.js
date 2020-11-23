__webpack_public_path__ = loadAppUrl();

import React from "react";
import ReactDOM from "react-dom";
import Roles from "../pages/Roles";
import PushService from "alexandria-ui-elements/src/services/PushService";
import FileService from "alexandria-ui-elements/src/services/FileService";
import TranslatorService from "alexandria-ui-elements/src/services/TranslatorService";
import GoogleApiLoader from "alexandria-ui-elements/src/displays/components/geo/GoogleApiLoader";
import DisplayRouter from "alexandria-ui-elements/src/displays/DisplayRouter";

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
		const content = requireGoogleApi ? <GoogleApiLoader onLoad={openPushServices()}><Roles/></GoogleApiLoader> : <Roles/>;
		const roles = document.getElementById("Roles");
		if (roles) ReactDOM.render(<DisplayRouter id="__router__" owner={()=>""} context={()=>""}>{content}</DisplayRouter>, roles);
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

function loadAppUrl() {
    let url = window.location.pathname !== "/" ? window.location.pathname : "";
    url = url.replace(new RegExp("\\/roles", 'g'), "");
    if (url.lastIndexOf("/") > 0) url = url.substr(0, window.location.pathname.lastIndexOf('/'));
    return url + "/unit-elements/";
}

launchApplication();