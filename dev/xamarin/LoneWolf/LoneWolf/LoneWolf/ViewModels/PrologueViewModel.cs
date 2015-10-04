using LoneWolf.Models;

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

		protected override string GenerateHtml()
		{
			if (Prologue == null) return string.Empty;

			switch (Prologue.Id)
			{
				default:
					return new PrologueView { Model = Prologue }.GenerateString();
			}
		}
	}
}