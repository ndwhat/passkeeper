package passkeeper.validators;

import passkeeper.objects.workspace.Category;
import passkeeper.objects.workspace.Project;
import passkeeper.objects.workspace.WorkSpaces;
import passkeeper.properties.Validator;

public class ProjectValidator implements InterfaceValidator {

    public Validator validate(String login, Category category, Project project) {
        Validator status = checkUnique(login, category, project);

        if (status.isError())
            return status;

        return Validator.SUCCESS_ADD;
    }

    public Validator validate(String login, Category category, String project) {
        Validator status = checkUnique(login, category, project);

        if (status.isError())
            return status;

        return Validator.SUCCESS_ADD;
    }
    private Validator checkUnique(String login, Category category, String project) {
        WorkSpaces workSpaces = new WorkSpaces();
        Validator validator = workSpaces.isUnique(login, category, project);
        if (validator.isError()) {
            return validator;
        }
        return Validator.SUCCESS_ADD;
    }


    private Validator checkUnique(String login, Category category, Project project) {
        WorkSpaces workSpaces = new WorkSpaces();
        Validator validator = workSpaces.isUnique(login, category, project);
        if (validator.isError()) {
            return validator;
        }
        return Validator.SUCCESS_ADD;
    }

}
