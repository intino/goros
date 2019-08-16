import NodePageNotifier from "./NodePageNotifier"

export default class DesktopPageNotifier extends NodePageNotifier {
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