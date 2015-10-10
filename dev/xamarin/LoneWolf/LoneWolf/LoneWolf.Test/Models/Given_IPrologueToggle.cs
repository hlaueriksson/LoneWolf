using System.Collections.Generic;
using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	public class Given_IPrologueToggle
	{
		[Subject(typeof(TheGameRulesToggle))]
		public class TheGameRulesToggle_
		{
			It should_disable_CombatSkill_if_rolled = () =>
			{
				var subject = new TheGameRulesToggle(new PrologueContext { ActionChart = new ActionChart { CombatSkill = new CombatSkill { Value = 1 } } });
				var html = "<a href=\"hybrid:combatskill\" id=\"CombatSkill\" class=\"enabled\">CombatSkill</a></p>";

				subject.Execute(html).ShouldContain("disabled");
			};

			It should_disable_Endurance_if_rolled = () =>
			{
				var subject = new TheGameRulesToggle(new PrologueContext { ActionChart = new ActionChart { Endurance = new Endurance { Value = 1, Max = 1 } } });
				var html = "<a href=\"hybrid:endurance\" id=\"Endurance\" class=\"enabled\">Endurance</a></p>";

				subject.Execute(html).ShouldContain("disabled");
			};
		}

		[Subject(typeof(KaiDisciplinesToggle))]
		public class KaiDisciplinesToggle_
		{
			It should_select_KaiDiscipline_if_acquired = () =>
			{
				var subject = new KaiDisciplinesToggle(new PrologueContext { ActionChart = new ActionChart { KaiDisciplines = new SortedSet<KaiDiscipline> { KaiDiscipline.Camouflage } } });
				var html = "<a href=\"hybrid:kaidiscipline/Camouflage\" id=\"Camouflage\" class=\"enabled\" onclick=\"toggleKaiDiscipline(this);\">Camouflage</a>";

				subject.Execute(html).ShouldContain("selected");
			};

			It should_disable_unselected_KaiDisciplines_if_5_disciplines_are_acquired = () =>
			{
				var subject = new KaiDisciplinesToggle(
					new PrologueContext
					{
						ActionChart = new ActionChart
						{
							KaiDisciplines = new SortedSet<KaiDiscipline>
							{
								KaiDiscipline.Hunting,
								KaiDiscipline.SixthSense,
								KaiDiscipline.Tracking,
								KaiDiscipline.Healing,
								KaiDiscipline.Weaponskill
							}
						}
					}
				);
				var html = "<a href=\"hybrid:kaidiscipline/Camouflage\" id=\"Camouflage\" class=\"enabled\" onclick=\"toggleKaiDiscipline(this);\">Camouflage</a>";

				subject.Execute(html).ShouldContain("disabled");
			};
		}
	}
}