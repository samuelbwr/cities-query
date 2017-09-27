package com.samuelbwr.interpreters;

import com.samuelbwr.statements.CountAll;
import com.samuelbwr.statements.CountDistinct;
import com.samuelbwr.statements.FilterByProperty;
import com.samuelbwr.statements.Statement;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CommandInterpreterTest {

    @Test
    public void ensureCanInterpretCountAll(){
        Statement statement = new CommandInterpreter().interpret( "count *" );
        Assert.assertThat( statement, CoreMatchers.instanceOf( CountAll.class ) );
    }

    @Test
    public void ensureCanInterpretCountDistinct(){
        Statement statement = new CommandInterpreter().interpret( "count distinct uf" );
        Assert.assertThat( statement, CoreMatchers.instanceOf( CountDistinct.class ) );
    }

    @Test
    public void ensureCanInterpretFilterByProperty(){
        Statement statement = new CommandInterpreter().interpret( "filter uf value" );
        Assert.assertThat( statement, CoreMatchers.instanceOf( FilterByProperty.class ) );
    }

    @Test(expected = CommandNotImplementedException.class)
    public void ensureCantInterpretInvalidCommand(){
        new CommandInterpreter().interpret( "add uf value" );
    }

}
