import { createMuiTheme } from '@material-ui/core/styles';

const Theme = (function () {
	var theme = null;
	var provider = {
		create: () => {
			theme = createMuiTheme({
				palette : {
				    primary : { main: "#005b9f" },
				    secondary : { main: "#ff9100" },
				    error : { main: "#f44336" },
				    contrastThreshold : "3",
				    tonalOffset : "0.2",
				    grey : {
				    	primary: "#888",
				    	secondary: '#ddd'
				    }
				},
				typography : {
				    fontFamily : '"-apple-system","BlinkMacSystemFont","Segoe UI","Roboto","Helvetica Neue","Arial","sans-serif","Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol"',
				    fontSize : 13,
				    useNextVariants: true
				},
				formats: {
				    h1: { color:'#B71C1C',textShadow:'2px 2px 2px #fff' },
				    h2: { color:'black',textShadow:'2px 2px 2px #fff' },
				    h3: {  },
				    h4: {  },
				    h5: {  },
				    h6: { lineHeight:'17pt' },
				    body1: {  },
				    body2: {  },
				    subtitle1: {  },
				    subtitle2: {  },
				    link: { color:'#ff9100' },
				    secondary: {  },
				    secondaryHighlighted: { color:'#ff9100',borderBottom:'1px solid white' },
				    separator: { borderRight:'1px solid black' },
				    main: { minHeight:'100%' },
				    footerFormat: { background:'#efefef',padding:'10px 30px',borderTop:'1px solid #aaa' },
				    headerSubtitle: { color:'white',position:'absolute',top:0,left:0,marginLeft:'180px',marginTop:'6px',textTransform:'uppercase',fontSize:'9pt' },
				    whiteBackground: { background:'white',borderRadius:'3px',height:'100%',border:'1px solid #efefef' },
				    air: { padding:'10px 20px' },
				    userHeader: { marginTop:'10px',paddingBottom:'10px',borderBottom:'1px solid #ddd' },
				    airTop: { marginTop:'10px' },
				    doubleAirTop: { marginTop:'20px' },
				    airBottom: { marginBottom:'10px' },
				    airLeft: { marginLeft:'10px' },
				    airTagsLeft: { marginLeft:'3px' },
				    airRight: { marginRight:'10px' },
				    airMenuRight: { marginRight:'4px' },
				    containerAirMedium: { padding:'10px' },
				    containerAirLarge: { padding:'20px' },
				    filled: { background:'#efefef',padding:'8px',minHeight:'300px' },
				    filledNoAir: { background:'#efefef',minHeight:'200px' },
				    filledNoAirLarge: { background:'#efefef',minHeight:'400px' },
				    headerToolbar: { marginTop:'10px' },
				    textCentered: { textAlign:'center' },
				    facetsAbsolute: { color:'#888',fontSize:'10px',marginTop:'-10px',position:'absolute' },
				    valuesLabelFormat: { whiteSpace:'nowrap' },
				    bordered: { border:'1px solid',width:'100%' },
				    paperFormat: { minHeight:'300px' },
				    underline: { borderBottom:'1px dotted #ddd',width:'100%',marginBottom:'10px' },
				    description: { fontSize:'10pt',color:'grey' },
				    minHeight: { minHeight:'100%' },
				    minWidth: { minWidth:'400px' },
				    minPhotoWidth: { minWidth:'100px' },
				    usersStampFormat: { height:'100%' },
				    relative: { position:'relative' },
				    contentCopyDashboardIcon: { position:'absolute',right:'44px',top:'-12px',background:'white',border:'1px solid #efefef' },
				    removeDashboardIcon: { position:'absolute',right:'-12px',top:'-12px',background:'white',border:'1px solid #efefef' },
				    thesaurus: { overflow:'auto',padding:'10px',minWidth:'300px',minHeight:'400px' },
				    grey: { background:'#efefef' },
				    loginError: { position:'absolute',bottom:'-10px',textAlign:'center',width:'100%',color:'red' },
				    backgroundLogin: { position:'absolute',bottom:'0',top:'0',width:'100%',height:'100%',zIndex:'0' },
				    logoLogin: { filter:'brightness(0) invert(1)',position:'absolute',margin:'30px' },
				    visible: { zIndex:'1' },
				    openUsersButton: { width:'150px' },
				    userNotGranted: { fontSize:'20pt',textAlign:'center',marginTop:'40px' },
				    cardTitle: { textAlign:'left',color:'#B71A1C',padding:'10px' },
				    cardContent: { textAlign:'left',padding:'10px' }
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