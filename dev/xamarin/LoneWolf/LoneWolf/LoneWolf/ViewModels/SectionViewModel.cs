using LoneWolf.Models;
using LoneWolf.Models.Book01;

namespace LoneWolf.ViewModels
{
	public class SectionViewModel : BaseBrowserViewModel
	{
		private Section _section;

		public Section Section
		{
			set
			{
				if (Equals(_section, value)) return;

				_section = value;
				OnPropertyChanged();

				Source = GetHtmlWebViewSource();
			}
			get { return _section; }
		}

		protected override string GenerateHtml()
		{
			if (Section == null) return string.Empty;

			switch (Section.Number)
			{
				case "0":
					return new Book01Section000View { Model = Section as Section000 }.GenerateString();
				default:
					return new SectionView { Model = Section }.GenerateString();
			}
		}
	}
}