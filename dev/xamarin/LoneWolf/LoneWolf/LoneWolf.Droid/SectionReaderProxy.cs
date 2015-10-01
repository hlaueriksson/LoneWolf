using System.IO;
using LoneWolf.Droid;
using LoneWolf.Models;
using Xamarin.Forms;

[assembly: Dependency(typeof(SectionReaderProxy))]
namespace LoneWolf.Droid
{
	public class SectionReaderProxy : ISectionReader
	{
		public string Read(SectionReference number)
		{
			var path = $"sections/sect{number.Number.PadLeft(3, '0')}.json";
			var stream = Forms.Context.Assets.Open(path);

			using (var reader = new StreamReader(stream))
			{
				return reader.ReadToEnd();
			}
		}
	}
}