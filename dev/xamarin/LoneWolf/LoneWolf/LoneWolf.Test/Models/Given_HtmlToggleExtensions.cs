using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	[Subject(typeof(HtmlToggleExtensions))]
	public class Given_HtmlToggleExtensions
	{
		public class Disable_id
		{
			It should_disable_matching_id = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("CombatSkill", () => true).ShouldEqual(" id=\"CombatSkill\" class=\"disabled\">");

			It should_not_disable_non_matching_id = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("Endurance", () => true).ShouldEqual(" id=\"CombatSkill\" class=\"enabled\">");

			It should_not_disable_false_toggle_func = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("CombatSkill", () => false).ShouldEqual(" id=\"CombatSkill\" class=\"enabled\">");
		}
	}
}