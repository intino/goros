package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ThemeTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("theme"))).output(literal("dsl Konos\n\n// FONTS\nFormat(\"color:'#05673c',textShadow:'2px 2px 2px #fff',fontSize:'25pt'\") h1\nFormat(\"color:'#05673c',textShadow:'2px 2px 2px #fff',fontSize:'20pt'\") h2\nFormat(\"fontSize:'15pt'\") h3\nFormat(\"fontSize:'14pt',fontWeight:'400'\") h4\nFormat(\"fontSize:'13pt'\") h5\nFormat(\"lineHeight:'17pt',fontSize:'12pt'\") h6\nFormat(\"fontSize:'11pt !important'\") body1\nFormat(\"fontSize:'10pt'\") body2\nFormat(\"\") subtitle1\nFormat(\"\") subtitle2\nFormat(\"fontWeight:'bold'\") bold\nFormat(\"\") secondary\nFormat(\"color:'#000'\") black\nFormat(\"color:'#777'\") grey\nFormat(\"color:'#F44335'\") red\nFormat(\"color:'#777'\") description\n\n// SPACED, AIR\nFormat(\"margin:'3px'\") smallAir\nFormat(\"margin:'10px 20px'\") air\nFormat(\"marginTop:'20px'\") doubleAirTop\nFormat(\"marginTop:'10px'\") airTop\nFormat(\"marginTop:'5px'\") middleAirTop\nFormat(\"marginTop:'3px'\") smallAirTop\nFormat(\"marginBottom:'20px'\") doubleAirBottom\nFormat(\"marginBottom:'10px'\") airBottom\nFormat(\"marginBottom:'5px'\") middleAirBottom\nFormat(\"marginLeft:'20px'\") doubleAirLeft\nFormat(\"marginLeft:'10px'\") airLeft\nFormat(\"marginLeft:'5px'\") middleAirLeft\nFormat(\"marginLeft:'3px'\") smallAirLeft\nFormat(\"marginRight:'20px'\") doubleAirRight\nFormat(\"marginRight:'10px'\") airRight\nFormat(\"marginRight:'5px'\") middleAirRight\nFormat(\"marginRight:'3px'\") smallAirRight\n\nFormat(\"padding:'5px'\") middleSpaced\nFormat(\"padding:'10px 20px'\") spaced\nFormat(\"paddingLeft:'10px'\") leftSpaced\nFormat(\"paddingTop:'5px'\") middleTopSpaced\nFormat(\"paddingTop:'10px'\") topSpaced\nFormat(\"paddingTop:'5px'\") middleTopSpaced\nFormat(\"paddingBottom:'10px'\") bottomSpaced\nFormat(\"paddingBottom:'5px'\") middleBottomSpaced\nFormat(\"paddingRight:'10px'\") rightSpaced\n\n// BORDERED\nFormat(\"border:'1px solid #e4e4e4'\") bordered\nFormat(\"borderTop:'1px solid #e4e4e4'\") topBordered\nFormat(\"borderTop:'1px dotted #ddd'\") topLightDottedBordered\nFormat(\"borderBottom:'1px solid #e4e4e4'\") bottomBordered\nFormat(\"borderBottom:'1px dotted #ddd'\") bottomLightDottedBordered\nFormat(\"borderRight:'1px solid #e4e4e4'\") rightBordered\nFormat(\"borderLeft:'1px solid #e4e4e4'\") leftBordered\n\n// COMMON\nFormat(\"zIndex:'1'\") visible\nFormat(\"position:'relative'\") relative\nFormat(\"minWidth:'72px'\") minLogoSize\nFormat(\"width:'100% !important'\") fullWidth\nFormat(\"height:'100% !important'\") fullHeight\nFormat(\"minWidth:'48px'\") minDrawerButtonSize\nFormat(\"overflow:'auto'\") autoOverflow\nFormat(\"background:'white',padding:'10px'\") dialog\n\n// OTHER\nFormat(\"background:'white',padding:'10px 15px',borderRadius:'10px'\") catalogIndexReferenceStyle\nFormat(\"borderTop:'1px solid #eee',marginTop:'6px',paddingTop:'6px'\") catalogIndexFooterItemStyle\nFormat(\"background:'white',padding:'10px 15px',borderRadius:'10px'\") catalogMapItemStyle\nFormat(\"borderTop:'1px solid #eee',marginTop:'6px',paddingTop:'6px'\") catalogMapFooterItemStyle\nFormat(\"background:'white',padding:'2px 0 2px 5px',borderRadius:'10px'\") termReferenceStyle\nFormat(\"padding:'10px',border:'1px solid #efefef',borderRadius:'5px',background:'white',marginBottom:'32px'\") compositeFieldStyle\nFormat(\"padding:'10px',border:'1px solid #efefef',borderRadius:'5px',background:'white',marginBottom:'32px'\") nodeFieldStyle\nFormat(\"position:'absolute',top:'0',background:'white',right:'0',borderRadius:'34px',border:'1px solid #ddd',marginTop:'-5px',marginRight:'2px'\") editDocumentButtonStyle\nFormat(\"fontSize:'10pt',color:'#0000008a',marginBottom:'5px'\") fieldLabel\nFormat(\"height:'20px'\") pillStyle\nFormat(\"minWidth:'230px'\") sourceLevelWidth\nFormat(\"borderRadius:'10px',padding:'0 4px',fontSize:'8pt'\") legendPillStyle"))
		);
	}
}