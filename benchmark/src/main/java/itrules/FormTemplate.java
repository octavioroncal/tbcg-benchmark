package itrules;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class FormTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("form")).output(literal("package com.example.form;\n\npublic class ")).output(placeholder("className")).output(literal(" {\n\t")).output(placeholder("field", "declare").multiple("\n")).output(literal("\n\n\tpublic ")).output(placeholder("className")).output(literal("() {\n\t\t")).output(placeholder("field", "declare").multiple("\n")).output(literal("\n\t}\n\n\t")).output(expression().output(placeholder("field", "get").multiple("\n"))).output(literal("\n\n\t")).output(expression().output(placeholder("field", "set").multiple("\n"))).output(literal("\n\n\tpublic void printFormDetails() {\n\t\tSystem.out.println(\"Form Details:\");\n\t\t")).output(expression().output(placeholder("field", "print").multiple("\n"))).output(literal("\n\t}\n}")));
		rules.add(rule().condition(all(allTypes("string"), trigger("declare"))).output(literal(" this.")).output(placeholder("name")).output(literal(" = \"")).output(expression().output(placeholder("defaultValue"))).output(literal("\";")));
		rules.add(rule().condition(all(allTypes("int"), trigger("declare"))).output(literal(" this.")).output(placeholder("name")).output(literal(" = ")).output(expression().output(placeholder("defaultValue")).next(expression().output(literal("0")))).output(literal(";")));
		rules.add(rule().condition(trigger("get")).output(literal("public ")).output(placeholder("type")).output(literal(" get")).output(placeholder("name", "FirstUpperCase")).output(literal("() {\n\treturn ")).output(placeholder("name")).output(literal(";\n}")));
		rules.add(rule().condition(trigger("set")).output(literal("public void set")).output(placeholder("name", "FirstUpperCase")).output(literal("(")).output(placeholder("type")).output(literal(" value) {\n\tthis.")).output(placeholder("name")).output(literal(" = value;\n}")));
		rules.add(rule().condition(trigger("print")).output(literal("System.out.println(\"")).output(placeholder("name")).output(literal(" (")).output(placeholder("type")).output(literal("): \" + ")).output(placeholder("name")).output(literal(");")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}