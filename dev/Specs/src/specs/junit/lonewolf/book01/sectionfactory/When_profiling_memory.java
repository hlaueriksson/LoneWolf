package specs.junit.lonewolf.book01.sectionfactory;

import net.sourceforge.sizeof.SizeOf;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class When_profiling_memory extends Given_SectionFactory {
    private long size;

    protected void when() {

        SizeOf.skipStaticField(true); // java.sizeOf will not compute static fields
        SizeOf.skipFinalField(true); // java.sizeOf will not compute final fields
        SizeOf.skipFlyweightObject(true); // java.sizeOf will not compute well-known flyweight objects

        size = SizeOf.deepSizeOf(manager); // object size in bytes
    }

    @Test
    public void then_the_size_should_be_moderate() {
        System.out.println(SizeOf.humanReadable(SizeOf.deepSizeOf(manager)));

        assertTrue(size < 100000);
    }
}
