using System.IO;
using LoneWolf.iOS;
using LoneWolf.Models;
using Xamarin.Forms;

[assembly: Dependency(typeof(SectionReaderProxy))]
namespace LoneWolf.iOS
{
	public class SectionReaderProxy : ISectionReader
	{
		public string Read(SectionReference number)
		{
			var path = $"sections/sect{number.Number.PadLeft(3, '0')}.json";

			return File.ReadAllText(path);
		}
	}
}