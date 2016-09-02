using LoneWolf.Models;

namespace LoneWolf
{
	public interface ISectionReader
	{
		string Read(SectionReference number);
	}
}