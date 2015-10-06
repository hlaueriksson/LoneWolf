using System;

namespace LoneWolf.Models
{
	public static class HtmlToggleExtensions
	{
		public static string Disable(this string html, string id, Func<bool> toggle)
		{
			if (!toggle()) return html;

			string enabled = $"id=\"{id}\" class=\"enabled\"";
			string disabled = $"id=\"{id}\" class=\"disabled\"";

			return html.Replace(enabled, disabled);
		}
	}
}