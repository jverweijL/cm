package cm.panel.application.list;

import cm.panel.constants.CmPanelPanelCategoryKeys;
import cm.panel.constants.CmPanelPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author jverweij
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + CmPanelPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class CmPanelPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return CmPanelPortletKeys.CMPANEL;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + CmPanelPortletKeys.CMPANEL + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}