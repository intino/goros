const I18n = (function () {

	var translators = {

	};

	var loader = {
		load: (lang) => {
			return translators[lang];
		}
	};

	return loader;
})();

export default I18n;