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
 * Contributor(s): Ehud Reiter, Albert Gatt, Dave Wewstwater, Roman Kutlak, Margaret Mitchell, Saad Mahamood.
 */

package simplenlg.syntax.galician;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import simplenlg.features.Feature;
import simplenlg.framework.CoordinatedPhraseElement;

// TODO: Auto-generated Javadoc

/**
 * This class groups together some tests for prepositional phrases and
 * coordinate prepositional phrases.
 *
 * @author agatt
 */
public class PrepositionalPhraseTest extends SimpleNLG4Test {

    /**
     * Instantiates a new pP test.
     *
     * @param name the name
     */
    public PrepositionalPhraseTest(String name) {
        super(name);
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
    }

    /**
     * Basic test for the pre-set PP fixtures.
     */
    @Test
    public void testBasic() {
        Assert.assertEquals("na habitación", this.realiser //$NON-NLS-1$
                .realise(this.inTheRoom).getRealisation());
        Assert.assertEquals("trala cortina", this.realiser //$NON-NLS-1$
                .realise(this.behindTheCurtain).getRealisation());
        Assert.assertEquals("na roca", this.realiser //$NON-NLS-1$
                .realise(this.onTheRock).getRealisation());
    }

    /**
     * Test for PP coordination.
     */
    public void testCoordination() {
        // simple coordination

        CoordinatedPhraseElement coord1 = phraseFactory.createCoordinatedPhrase(
                this.inTheRoom, this.behindTheCurtain);
        Assert.assertEquals("na habitación e trala cortina", this.realiser //$NON-NLS-1$
                .realise(coord1).getRealisation());

        // change the conjunction
        coord1.setFeature(Feature.CONJUNCTION, "ou"); //$NON-NLS-1$
        Assert.assertEquals("na habitación ou trala cortina", this.realiser //$NON-NLS-1$
                .realise(coord1).getRealisation());

        // new coordinate
        CoordinatedPhraseElement coord2 = phraseFactory.createCoordinatedPhrase(
                this.onTheRock, this.underTheTable);
        coord2.setFeature(Feature.CONJUNCTION, "ou"); //$NON-NLS-1$
        Assert.assertEquals("na roca ou baixo a mesa", this.realiser //$NON-NLS-1$
                .realise(coord2).getRealisation());

        // coordinate two coordinates
        CoordinatedPhraseElement coord3 = phraseFactory.createCoordinatedPhrase(coord1,
                coord2);

        String text = this.realiser.realise(coord3).getRealisation();
        Assert
                .assertEquals(
                        "na habitación ou trala cortina e na roca ou baixo a mesa", //$NON-NLS-1$
                        text);
    }
}
