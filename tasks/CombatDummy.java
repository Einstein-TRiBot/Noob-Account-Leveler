package scripts.NoobAccountLeveler.tasks;

import static scripts.NoobAccountLeveler.data.Constants.DUMMY;
import static scripts.NoobAccountLeveler.data.Constants.VARROCK_GYM_AREA;

import scripts.NoobAccountLeveler.data.Vars;
import scripts.NoobAccountLeveler.framework.AbstractTask;
import scripts.NoobAccountLeveler.util.ScriptUtil;
/**
 * 
 * @author Einstein
 *
 *
 */
public class CombatDummy implements AbstractTask {
	
	@Override
	public String info() {
		return "Pump iron at the Varrock gym";
	}

	@Override
	public boolean shouldExecute() {
		 return !Vars.get().doneAttack;
	}

	@Override
	public void execute() {
		if(ScriptUtil.getInArea(VARROCK_GYM_AREA))
			if(ScriptUtil.interactObject("Attack", DUMMY))
				ScriptUtil.waitToFishishAnimation();
	}

}