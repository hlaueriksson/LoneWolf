using System.Collections.Generic;
using LoneWolf.Models;
using LoneWolf.Test.Factory;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	public class Given_ActionChart
	{
		[Subject(typeof(ActionChart))]
		public class New
		{
			It should_initialize_properties = () =>
			{
				var subject = new ActionChart();

				subject.CombatSkill.ShouldNotBeNull();
				subject.Endurance.ShouldNotBeNull();
				subject.KaiDisciplines.ShouldNotBeNull();
				subject.WeaponSkill.ShouldNotBeNull();
			};

			It should_be_able_to_Serialize_and_Deserialize = () =>
			{
				var subject = new ActionChart();
				subject.CombatSkill.Set(10);
				subject.Endurance.Set(20);
				subject.KaiDisciplines.Add(KaiDiscipline.AnimalKinship);
				subject.WeaponSkill = WeaponSkill.Axe;

				var json = subject.TypedSerialize();
				var result = json.TypedDeserialize<ActionChart>();

				result.CombatSkill.Value.ShouldEqual(10);
				result.Endurance.Value.ShouldEqual(20);
				result.Endurance.Max.ShouldEqual(20);
				result.KaiDisciplines.ShouldEqual(new SortedSet<KaiDiscipline> { KaiDiscipline.AnimalKinship });
				result.WeaponSkill.ShouldEqual(WeaponSkill.Axe);
			};
		}

		[Subject(typeof(CombatSkill))]
		public class CombatSkill_
		{
			It should_be_able_to_set_value = () =>
			{
				var subject = new CombatSkill();
				var value = 10;

				subject.Set(value);
				subject.Value.ShouldEqual(value);
			};
		}

		[Subject(typeof(Endurance))]
		public class Endurance_
		{
			It should_be_able_to_set_value = () =>
			{
				var subject = new Endurance();
				var value = 10;

				subject.Set(value);
				subject.Max.ShouldEqual(value);
				subject.Value.ShouldEqual(value);
			};

			It should_be_able_to_increment_value = () =>
			{
				var subject = new Endurance { Value = 18, Max = 20 };

				subject.Increment(2);
				subject.Value.ShouldEqual(20);
			};

			It should_not_be_able_to_increment_value_more_than_max = () =>
			{
				var subject = new Endurance { Value = 18, Max = 20 };

				subject.Increment(4);
				subject.Value.ShouldEqual(20);
			};

			It should_be_able_to_decrement_value = () =>
			{
				var subject = new Endurance { Value = 18, Max = 20 };

				subject.Decrement(2);
				subject.Value.ShouldEqual(16);
			};

			It should_not_be_able_to_decrement_value_less_than_0 = () =>
			{
				var subject = new Endurance { Value = 18, Max = 20 };

				subject.Decrement(20);
				subject.Value.ShouldEqual(0);
			};
		}

		[Subject(typeof(BeltPouch))]
		public class BeltPouch_
		{
			It should_be_able_to_set_value = () =>
			{
				var subject = new BeltPouch();
				var value = 10;

				subject.Set(value);
				subject.Value.ShouldEqual(value);
			};

			It should_not_be_less_then_0 = () =>
			{
				var subject = new BeltPouch();

				subject.Set(-1);
				subject.Value.ShouldEqual(0);
			};

			It should_not_be_more_then_50 = () =>
			{
				var subject = new BeltPouch();

				subject.Set(51);
				subject.Value.ShouldEqual(50);
			};
		}

		[Subject(typeof(ActionChart))]
		public class Has_KaiDiscipline
		{
			static ActionChart subject;

			Establish context = () =>
			{
				subject = new ActionChart();
				subject.KaiDisciplines.Add(KaiDiscipline.AnimalKinship);
			};

			It should_be_true_if_acquired = () => subject.Has(KaiDiscipline.AnimalKinship).ShouldBeTrue();

			It should_be_false_if_not_acquired = () => subject.Has(KaiDiscipline.Camouflage).ShouldBeFalse();
		}
	}
}