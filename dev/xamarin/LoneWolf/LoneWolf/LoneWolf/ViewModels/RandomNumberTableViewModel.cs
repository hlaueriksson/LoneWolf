using LoneWolf.Models;

namespace LoneWolf.ViewModels
{
	public class RandomNumberTableViewModel : BaseViewModel
	{
		private RandomNumberResult _result;

		public RandomNumberResult Result
		{
			set
			{
				if (Equals(_result, value)) return;

				_result = value;
				OnPropertyChanged();
			}
			get { return _result; }
		}
	}
}