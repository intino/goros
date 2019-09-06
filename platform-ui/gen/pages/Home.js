import React from "react";
import { MuiThemeProvider, withStyles } from '@material-ui/core/styles';
import { SnackbarProvider } from "notistack";
import CssBaseline from '@material-ui/core/CssBaseline';
import Theme from '../../gen/Theme';
import Page from "alexandria-ui-elements/src/displays/Page";
import ConnectionChecker from "alexandria-ui-elements/src/displays/ConnectionChecker";
import DesktopPage from "../../src/displays/templates/DesktopPage";


let theme = Theme.create();
const styles = theme => ({});

export default class Home extends Page {
render() {
    const { classes } = this.props;
    return (
		<MuiThemeProvider theme={theme}>
        	<SnackbarProvider maxSnack={3}>
        		<CssBaseline />
    			<DesktopPage id="vm"></DesktopPage>
    			<ConnectionChecker></ConnectionChecker>
			</SnackbarProvider>
		</MuiThemeProvider>
    );
}
}