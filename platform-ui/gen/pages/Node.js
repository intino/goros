import React from "react";
import { MuiThemeProvider, withStyles } from '@material-ui/core/styles';
import { SnackbarProvider } from "notistack";
import CssBaseline from '@material-ui/core/CssBaseline';
import Theme from '../../gen/Theme';
import Page from "alexandria-ui-elements/src/displays/Page";
import ConnectionChecker from "alexandria-ui-elements/src/displays/ConnectionChecker";
import NodePage from "../../src/displays/templates/NodePage";


let theme = Theme.create();
const styles = theme => ({});

export default class Node extends Page {
render() {
    const { classes } = this.props;
    return (
		<MuiThemeProvider theme={theme}>
        	<SnackbarProvider maxSnack={3}>
        		<CssBaseline />
    			<NodePage id="rE"></NodePage>
    			<ConnectionChecker></ConnectionChecker>
			</SnackbarProvider>
		</MuiThemeProvider>
    );
}
}