using LoneWolf.Models;

namespace LoneWolf.Views
{
	public static class ViewExtensions
	{
		public static string GetCssClass(this PrologueReference model)
		{
			return model == PrologueReference.Null ? "disabled" : "enabled";
		}

		public static string GetCssClass(this Choice model)
		{
			if (model.Toggle == null) return "enabled";

			return model.Toggle.IsEnabled() ? "enabled" : "disabled";
		}
	}
}