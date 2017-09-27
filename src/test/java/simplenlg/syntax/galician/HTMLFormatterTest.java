/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is "Simplenlg".
 *
 * The Initial Developer of the Original Code is Ehud Reiter, Albert Gatt and Dave Westwater.
 * Portions created by Ehud Reiter, Albert Gatt and Dave Westwater are Copyright (C) 2010-11 The University of Aberdeen. All Rights Reserved.
 *
 * Contributor(s): Ehud Reiter, Albert Gatt, Dave Westwater, Roman Kutlak, Margaret Mitchell, Saad Mahamood.
 */

package simplenlg.syntax.galician;

import org.junit.After;
import org.junit.Test;
import simplenlg.format.english.HTMLFormatter;
import simplenlg.framework.DocumentElement;
import simplenlg.framework.NLGElement;
import simplenlg.phrasespec.SPhraseSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// HTMLFormatter and HTMLFormatterTest ~ author James Christie, but taken from TextFormatter and TextFormatterTest

public class HTMLFormatterTest extends SimpleNLG4Test {

    /**
     * Instantiates a new document element test.
     *
     * @param name the name
     */
    public HTMLFormatterTest(String name) {
        super(name);
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
    }


    /**
     * Check the correct [part] web page contents are being generated
     */
    @Test
    public final void testWebPageContent() {
        // now build a document ...
        DocumentElement document = phraseFactory.createDocument("Isto é un título");

        DocumentElement section = phraseFactory.createSection("Isto é unha sección");

        DocumentElement paragraph1 = phraseFactory.createParagraph();
        DocumentElement sentence11 = phraseFactory.createSentence("Esta é a primeira oración do párrafo 1");
        paragraph1.addComponent(sentence11);
        DocumentElement sentence12 = phraseFactory.createSentence("Esta é a segunda oración do párrafo 1");
        paragraph1.addComponent(sentence12);
        section.addComponent(paragraph1);
        document.addComponent(section);

        DocumentElement paragraph2 = phraseFactory.createParagraph();
        DocumentElement sentence2 = phraseFactory.createSentence("Esta é a primeira oración do párrafo 2");
        paragraph2.addComponent(sentence2);
        document.addComponent(paragraph2);

        DocumentElement paragraph3 = phraseFactory.createParagraph();
        DocumentElement sentence3 = phraseFactory.createSentence("Esta é a primeira oración do párrafo 3");
        paragraph3.addComponent(sentence3);
        document.addComponent(paragraph3);

        // now for a second section with three sentences in one paragraph using arrays.asList function
        SPhraseSpec p1 = phraseFactory.createClause("Mary", "perseguir", "o mono");
        SPhraseSpec p2 = phraseFactory.createClause("o mono", "pelexar");
        SPhraseSpec p3 = phraseFactory.createClause("Mary", "estar", "nerviosa");

        DocumentElement s1 = phraseFactory.createSentence(p1);
        DocumentElement s2 = phraseFactory.createSentence(p2);
        DocumentElement s3 = phraseFactory.createSentence(p3);

        DocumentElement para1x3 = phraseFactory.createParagraph(Arrays.asList(s1, s2, s3));

        DocumentElement sectionList = phraseFactory.createSection("Esta sección contén listas");
        sectionList.addComponent(para1x3);
        document.addComponent(sectionList);

        // from David Westwater 4-10-11
        DocumentElement element = phraseFactory.createList();
        List<NLGElement> list = new ArrayList<NLGElement>();
        list.add(phraseFactory.createListItem(phraseFactory.createStringElement("Item 1")));
        list.add(phraseFactory.createListItem(phraseFactory.createStringElement("Item 2")));
        list.add(phraseFactory.createListItem(phraseFactory.createStringElement("Item 3")));

        element.addComponents(list);
        document.addComponent(element);

        // ... finally produce some output with HMTL tags ...
        System.out.println("HTML realisation ~ \n=============================\n");

        String output = "";

        // this.realiser.setFormatter( new TextFormatter( ) ) ;
        this.realiser.setFormatter(new HTMLFormatter());
        // realiser.setDebugMode( true ) ; // hide after testing
        output += realiser.realise(document).getRealisation();

        System.out.println(output); // just to visually check what is being produced

        String expectedResults =
                "<h1>Isto é un título</h1>" +
                        "<h2>Isto é unha sección</h2>" +
                        "<p>Esta é a primeira oración do párrafo 1. Esta é a segunda oración do párrafo 1.</p>" +
                        "<p>Esta é a primeira oración do párrafo 2.</p>" +
                        "<p>Esta é a primeira oración do párrafo 3.</p>" +
                        "<h2>Esta sección contén listas</h2>" +
                        "<p>Mary persegue o mono. O mono pelexa. Mary está nerviosa.</p>" +
                        "<ul>" +
                        "<li>Item 1</li>" +
                        "<li>Item 2</li>" +
                        "<li>Item 3</li>" +
                        "</ul>";

        assertEquals(expectedResults, output); // when realisation is working then complete this test
    } // testWebPageContents
} // class

	
