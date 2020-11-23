import { createMuiTheme } from '@material-ui/core/styles';

const Theme = (function () {
	var theme = null;
	var provider = {
		create: () => {
			theme = createMuiTheme({
				palette : {

				},
				typography : {

				},
				formats: {
				    h1: { color:'#05673c',textShadow:'2px 2px 2px #fff',fontSize:'25pt' },
				    h2: { color:'#05673c',textShadow:'2px 2px 2px #fff',fontSize:'20pt' },
				    h3: { fontSize:'15pt' },
				    h4: { fontSize:'14pt',fontWeight:'400' },
				    h5: { fontSize:'13pt' },
				    h6: { lineHeight:'17pt',fontSize:'12pt' },
				    body1: { fontSize:'11pt !important' },
				    body2: { fontSize:'10pt' },
				    subtitle1: {  },
				    subtitle2: {  },
				    bold: { fontWeight:'bold' },
				    secondary: {  },
				    black: { color:'#000' },
				    grey: { color:'#777' },
				    red: { color:'#F44335' },
				    description: { color:'#777' },
				    smallAir: { margin:'3px' },
				    air: { margin:'10px 20px' },
				    doubleAirTop: { marginTop:'20px' },
				    airTop: { marginTop:'10px' },
				    middleAirTop: { marginTop:'5px' },
				    smallAirTop: { marginTop:'3px' },
				    doubleAirBottom: { marginBottom:'20px' },
				    airBottom: { marginBottom:'10px' },
				    middleAirBottom: { marginBottom:'5px' },
				    doubleAirLeft: { marginLeft:'20px' },
				    airLeft: { marginLeft:'10px' },
				    middleAirLeft: { marginLeft:'5px' },
				    smallAirLeft: { marginLeft:'3px' },
				    doubleAirRight: { marginRight:'20px' },
				    airRight: { marginRight:'10px' },
				    middleAirRight: { marginRight:'5px' },
				    smallAirRight: { marginRight:'3px' },
				    middleSpaced: { padding:'5px' },
				    spaced: { padding:'10px 20px' },
				    leftSpaced: { paddingLeft:'10px' },
				    middleTopSpaced: { paddingTop:'5px' },
				    bottomSpaced: { paddingBottom:'10px' },
				    middleBottomSpaced: { paddingBottom:'5px' },
				    rightSpaced: { paddingRight:'10px' },
				    bordered: { border:'1px solid #e4e4e4' },
				    topBordered: { borderTop:'1px solid #e4e4e4' },
				    topLightDottedBordered: { borderTop:'1px dotted #ddd' },
				    bottomBordered: { borderBottom:'1px solid #e4e4e4' },
				    bottomLightDottedBordered: { borderBottom:'1px dotted #ddd' },
				    rightBordered: { borderRight:'1px solid #e4e4e4' },
				    leftBordered: { borderLeft:'1px solid #e4e4e4' },
				    visible: { zIndex:'1' },
				    relative: { position:'relative' },
				    minLogoSize: { minWidth:'72px' },
				    fullWidth: { width:'100% !important' },
				    fullHeight: { height:'100% !important' },
				    minDrawerButtonSize: { minWidth:'48px' },
				    autoOverflow: { overflow:'auto' },
				    dialog: { background:'white',padding:'10px' },
				    catalogIndexReferenceStyle: { background:'white',padding:'10px 15px',borderRadius:'10px' },
				    catalogIndexFooterItemStyle: { borderTop:'1px solid #eee',marginTop:'6px',paddingTop:'6px' },
				    catalogMapItemStyle: { background:'white',padding:'10px 15px',borderRadius:'10px' },
				    catalogMapFooterItemStyle: { borderTop:'1px solid #eee',marginTop:'6px',paddingTop:'6px' },
				    termReferenceStyle: { background:'white',padding:'2px 0 2px 5px',borderRadius:'10px' },
				    compositeFieldStyle: { padding:'10px',border:'1px solid #efefef',borderRadius:'5px',background:'white',marginBottom:'32px' },
				    nodeFieldStyle: { padding:'10px',border:'1px solid #efefef',borderRadius:'5px',background:'white',marginBottom:'32px' },
				    editDocumentButtonStyle: { position:'absolute',top:'0',background:'white',right:'0',borderRadius:'34px',border:'1px solid #ddd',marginTop:'-5px',marginRight:'2px' },
				    fieldLabel: { fontSize:'10pt',color:'#0000008a',marginBottom:'5px' },
				    pillStyle: { height:'20px' },
				    sourceLevelWidth: { minWidth:'320px' },
				    legendPillStyle: { borderRadius:'10px',padding:'0 4px',fontSize:'8pt' }
				}
			});
			return theme;
		},
		get: () => {
			return theme;
		},
	};
	return provider;
})();

export default Theme;