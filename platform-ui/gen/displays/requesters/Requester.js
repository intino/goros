export default class Requester {
	constructor(element) {
		this.element = element;
		this.pushService = Application.services.pushService;
		this.fileService = Application.services.fileService;
	};

    available = (unit) => {
        return this.pushService.existsConnection(unit);
    };
}