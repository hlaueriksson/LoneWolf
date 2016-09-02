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

				Source = GetHtmlWebViewSource(GetToggle());
			}
			get { return _prologue; }
		}

		public ActionChart ActionChart { get; set; }

		private PrologueContext PrologueContext => new PrologueContext { Prologue = Prologue, ActionChart = ActionChart };

		public void Update()
		{
			Source = GetHtmlWebViewSource();
		}

		protected override string GenerateHtml()
		{
			if (Prologue == null) return string.Empty;

			return new PrologueView { Model = Prologue }.GenerateString();
		}

		private IPrologueToggle GetToggle()
		{
			if (Prologue.Id == PrologueReference.TheGameRules) return new TheGameRulesToggle(PrologueContext);
			if (Prologue.Id == PrologueReference.KaiDisciplines) return new KaiDisciplinesToggle(PrologueContext);
			if (Prologue.Id == PrologueReference.Equipment) return new EquipmentToggle(PrologueContext);

			return new NullPrologueToggle();
		}
	}
}