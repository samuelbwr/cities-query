package com.samuelbwr.cities;

import com.samuelbwr.interpreters.CommandInterpreter;
import com.samuelbwr.interpreters.Interpreter;
import com.samuelbwr.statements.Result;
import com.samuelbwr.statements.Statement;

public class CityService {

    private CityDao dao;
    private Interpreter interpreter;

    public CityService(String fileLocation) {
        dao = new CityDao( fileLocation );
        interpreter = new CommandInterpreter();
    }

    public Result runCommand(String command) {
        Statement statement = interpreter.interpret( command );
        return dao.runStatement( statement );
    }
}
