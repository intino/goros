import Notifier from "alexandria-ui-elements/gen/displays/notifiers/TemplateNotifier";

export default class PageNotifier extends Notifier {
	constructor(element) {
		super(element);
		this.setup();
	};

	setup() {
		if (this.element == null || this.pushLinked) return;
		super.setup();
		this.pushLinked = true;
	};
}