import NodeViewNotifier from "./NodeViewNotifier"

export default class CollectionViewNotifier extends NodeViewNotifier {
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