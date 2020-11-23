import history from "alexandria-ui-elements/src/util/History";

export default class Requester {
	constructor(element) {
		this.element = element;
		this.pushService = Application.services.pushService;
		this.fileService = Application.services.fileService;
	};

    available = (unit) => {
        return this.pushService.existsConnection(unit);
    };

    addToHistory = (param) => {
        const address = this.element.historyAddress();
        const id = (param instanceof Array) ? (param.length > 0 ? param[0] : "") : param;
        if (address == null) return false;
        history.push(address.replace(/:[^\/]*/, id), {});
        return true;
    };
}