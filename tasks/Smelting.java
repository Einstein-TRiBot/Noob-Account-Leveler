package scripts.NoobAccountLeveler.tasks;

import static scripts.NoobAccountLeveler.data.Constants.COPPER_ORE;
import static scripts.NoobAccountLeveler.data.Constants.FURANCE;
import static scripts.NoobAccountLeveler.data.Constants.SMELTING_AREA;
import static scripts.NoobAccountLeveler.data.Constants.TIN_ORE;

import scripts.NoobAccountLeveler.data.Vars;
import scripts.NoobAccountLeveler.framework.AbstractTask;
import scripts.NoobAccountLeveler.util.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class Smelting implements AbstractTask {

	@Override
	public String info() {
		return "Smelting";
	}

	@Override
	public boolean shouldExecute() {
		return !Vars.get().doneSmelting && Vars.get().doneMining;
	}

	@Override
	public void execute() {
		// Resource availability check
		if (!ScriptUtil.isResourceStillAvailable(TIN_ORE, COPPER_ORE))
			Vars.get().doneSmelting = true;

		// Smelting
		if (ScriptUtil.fetchResources(-1, TIN_ORE, COPPER_ORE))
			if (ScriptUtil.getInArea(SMELTING_AREA)) {
				if (ScriptUtil.interactObject("Smelt", FURANCE))
					ScriptUtil.waitForInterface(270);
				if (ScriptUtil.handleInterface(270, 14, "Smelt Bronze bar"))
					ScriptUtil.waitUntilAmountOfResourcesLeft(0, TIN_ORE, COPPER_ORE);
			}
	}

}