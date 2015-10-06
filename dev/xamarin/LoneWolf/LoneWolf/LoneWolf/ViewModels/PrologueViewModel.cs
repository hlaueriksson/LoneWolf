using LoneWolf.Models;
using Xamarin.Forms;

namespace LoneWolf.ViewModels
{
	public class PrologueViewModel : BaseBrowserViewModel
	{
		private Prologue _prologue;

		public Prologue Prologue
		{
			set
			{
				if (Equals(_prologue, value)) return;

				_prologue = value;
				OnPropertyChanged();

				Source = GetHtmlWebViewSource();
			}
			get { return _prologue; }
		}

		public ActionChart ActionChart { get; set; }

		private PrologueContext PrologueContext => new PrologueContext { Prologue = Prologue, ActionChart = ActionChart };

		protected override HtmlWebViewSource GetHtmlWebViewSource()
		{
			var result = base.GetHtmlWebViewSource();

			result.Html = GetToggle().Execute(result.Html);

			return result;
		}

		protected override string GenerateHtml()
		{
			if (Prologue == null) return string.Empty;

			return new PrologueView { Model = Prologue }.GenerateString();
		}

		private IPrologueToggle GetToggle()
		{
			if (Prologue.Id == PrologueReference.TheGameRules) return new TheGameRulesToggle(PrologueContext);

			return new NullPrologueToggle();
		}

		private void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}