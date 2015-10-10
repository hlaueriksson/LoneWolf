using LoneWolf.Models;
using LoneWolf.Views;
using Xamarin.Forms;

namespace LoneWolf
{
	public class App : Application
	{
		private PropertiesRepository<ActionChart> ActionChartRepository { get; } = new PropertiesRepository<ActionChart>();

		public App()
		{
			Init();

			// The root page of your application
			MainPage = new NavigationPage(new ProloguePage()); // new TestSectionPage();
		}

		protected override void OnStart()
		{
			// Handle when your app starts
		}

		protected override void OnSleep()
		{
			// Handle when your app sleeps
		}

		protected override void OnResume()
		{
			// Handle when your app resumes
		}

		private void Init()
		{
			//ActionChartRepository.Remove();

			if (ActionChartRepository.Exists()) return;

			ActionChartRepository.Add(new ActionChart());
			//ActionChartRepository.SaveAsync();
		}
	}
}