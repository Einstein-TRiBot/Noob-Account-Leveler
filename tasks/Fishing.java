package scripts.NoobAccountLeveler.tasks;

import static scripts.NoobAccountLeveler.data.Constants.FISHING_AREA;
import static scripts.NoobAccountLeveler.data.Constants.FISHING_SPOT;
import static scripts.NoobAccountLeveler.data.Constants.SMALL_FISHING_NET;

import scripts.NoobAccountLeveler.data.Vars;
import scripts.NoobAccountLeveler.framework.AbstractTask;
import scripts.NoobAccountLeveler.util.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class Fishing implements AbstractTask {

	@Override
	public String info() {
		return "Fishing";
	}

	@Override
	public boolean shouldExecute() {
		return !Vars.get().doneFishing;
	}

	@Override
	public void execute() {
		if (ScriptUtil.fetchTool(SMALL_FISHING_NET))
			if (ScriptUtil.handleFullInventory(SMALL_FISHING_NET))
				if (ScriptUtil.getInArea(FISHING_AREA))
					if (ScriptUtil.interactNPC("Net", FISHING_SPOT))
						ScriptUtil.waitToAnimate();
	}
	
}