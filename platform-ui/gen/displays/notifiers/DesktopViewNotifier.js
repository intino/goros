import NodeViewNotifier from "./NodeViewNotifier"

export default class DesktopViewNotifier extends NodeViewNotifier {
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