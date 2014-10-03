/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.renderers;

import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.ReportTest;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleViolation;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.ParametricRuleViolation;

import org.junit.Assert;
import org.junit.Test;

public class XSLTRendererTest {

    @Test
    public void testDefaultStylesheet() throws Exception {
        XSLTRenderer renderer = new XSLTRenderer();
        Report report = new Report();
        RuleViolation rv = new ParametricRuleViolation<Node>(new ReportTest.FooRule(), new RuleContext(),
                ReportTest.getNode(1, 1, "some scope"),
                "violation message");
        report.addRuleViolation(rv);
        String result = ReportTest.render(renderer, report);
        Assert.assertTrue(result.contains("violation message"));
    }
}
