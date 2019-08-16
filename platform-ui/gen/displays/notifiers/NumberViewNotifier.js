import FieldViewNotifier from "./FieldViewNotifier"

export default class NumberViewNotifier extends FieldViewNotifier {
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