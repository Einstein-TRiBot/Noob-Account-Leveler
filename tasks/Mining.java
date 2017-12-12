package scripts.NoobAccountLeveler.tasks;

import static scripts.NoobAccountLeveler.data.Constants.*;

import org.tribot.api2007.Inventory;

import scripts.NoobAccountLeveler.data.Vars;
import scripts.NoobAccountLeveler.framework.AbstractTask;
import scripts.NoobAccountLeveler.util.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class Mining implements AbstractTask {

	private int[] rocks;

	@Override
	public String info() {
		return "Mining";
	}

	@Override
	public boolean shouldExecute() {
		return !Vars.get().doneMining;
	}

	@Override
	public void execute() {
		// Equip pickaxe if required
		ScriptUtil.equipTool(PICKAXES);

		// Decide what rocks to mine
		if (Inventory.getCount(TIN_ORE) < 14)
			rocks = TIN_ROCK;
		else
			rocks = COPPER_ROCK;

		// Mining
		if (ScriptUtil.fetchTool(PICKAXES))
			if (ScriptUtil.handleFullInventory(PICKAXES))
				if (ScriptUtil.getInArea(MINING_AREA))
					if (ScriptUtil.interactObject("Mine", rocks))
						ScriptUtil.waitToAnimate();
	}

}