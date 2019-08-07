import React from "react";
import { withStyles } from '@material-ui/core/styles';
import AbstractCollectionView from "../../../gen/displays/templates/AbstractCollectionView";
import CollectionViewNotifier from "../../../gen/displays/notifiers/CollectionViewNotifier";
import CollectionViewRequester from "../../../gen/displays/requesters/CollectionViewRequester";
import DisplayFactory from 'alexandria-ui-elements/src/displays/DisplayFactory';
import { withSnackbar } from 'notistack';

const styles = theme => ({});

class CollectionView extends AbstractCollectionView {

	constructor(props) {
		super(props);
		this.notifier = new CollectionViewNotifier(this);
		this.requester = new CollectionViewRequester(this);
	};


}

export default withStyles(styles, { withTheme: true })(withSnackbar(CollectionView));
DisplayFactory.register("CollectionView", withStyles(styles, { withTheme: true })(withSnackbar(CollectionView)));