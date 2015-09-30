using System;
using LoneWolf.Models;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class SectionPage : ContentPage
	{
		public SectionPage()
		{
			InitializeComponent();

			UpdateModel("1");
		}

		private void Browser_OnNavigating(object sender, WebNavigatingEventArgs e)
		{
			Log("Browser_OnNavigating");

			e.Cancel = true;

			var number = GetSectionNumber(e.Url);

			UpdateModel(number);
		}

		private void Browser_OnNavigated(object sender, WebNavigatedEventArgs e)
		{
			Log("Browser_OnNavigated");
		}

		private string GetSectionNumber(string url)
		{
			return url.Replace("hybrid:section/", string.Empty);
		}

		private void UpdateModel(string number)
		{
			var model = BindingContext as SectionViewModel;

			if (model == null) return;

			model.Section = GetSection(number);
		}

		private static Section GetSection(string number)
		{
			var random = new Random();
			var max = 250;

			return new Section
			{
				Number = number,
				Body =
@"
  <p>You must make haste for you sense it is not safe to linger by the smoking remains of the ruined monastery. The black-winged beasts could return at any moment. You must set out for the Sommlending capital of Holmgard and tell the King the terrible news of the massacre: that the whole élite of Kai warriors, save yourself, have been slaughtered. Without the Kai Lords to lead her armies, Sommerlund will be at the mercy of their ancient enemy, the Darklords.</p>
  <p>Fighting back tears, you bid farewell to your dead kinsmen. Silently, you promise that their deaths will be avenged. You turn away from the ruins and carefully descend the steep track.</p>
  <p>At the foot of the hill, the path splits into two directions, both leading into a large wood.</p>
",
				Choices = new[]
				{
					new Choice { Number = random.Next(max).ToString() },
					new Choice { Number = random.Next(max).ToString() },
					new Choice { Number = random.Next(max).ToString() }
				}
			};
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}