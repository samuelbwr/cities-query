package com.samuelbwr.interpreters;

import com.samuelbwr.statements.Count;
import com.samuelbwr.statements.Filter;
import com.samuelbwr.statements.Statement;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CommandInterpreterTest {

    @Test
    public void ensureCanInterpretCountAll(){
        Statement statement = new CommandInterpreter().interpret( "count *" );
        Assert.assertThat( statement, CoreMatchers.instanceOf( Count.All.class ) );
    }

    @Test
    public void ensureCanInterpretCountDistinct(){
        Statement statement = new CommandInterpreter().interpret( "count distinct something" );
        Assert.assertThat( statement, CoreMatchers.instanceOf( Count.Distinct.class ) );
    }

    @Test
    public void ensureCanInterpretFilterByProperty(){
        Statement statement = new CommandInterpreter().interpret( "filter uf value" );
        Assert.assertThat( statement, CoreMatchers.instanceOf( Filter.ByProperty.class ) );
    }

    @Test(expected = CommandNotFoundException.class)
    public void ensureCantInterpretInvalidCommand(){
        new CommandInterpreter().interpret( "add uf value" );
    }

}
