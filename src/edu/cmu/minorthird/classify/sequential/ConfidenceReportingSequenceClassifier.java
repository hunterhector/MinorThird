package edu.cmu.minorthird.classify.sequential;

import edu.cmu.minorthird.classify.*;

/**
 * A sequence classifier that can report on the confidence associated
 * with any subsequence of a sequential classification.
 *
 * @author William Cohen
 */

public interface ConfidenceReportingSequenceClassifier
{
    /** 
     * Return a measure of confidence that the correct ClassLabels for
     * indices lo...hi-1 of the 'sequence' are in fact the ones in
     * 'predictedClasses[lo..hi-1]', rather than the ones given in
     * in 'alternateClasses'.
     * 
     * <p>Since classifications in the sequence are not independent,
     * the values of 'alternateClasses' in positions outside of
     * lo..hi-1 may affect this confidence.
     * 
     * <p>NULL values in the alternateClasses array indicate positions
     * for which no alternate ClassLabels are required.  In this case,
     * the confidence returned should be (approximately) the maximum
     * over all possible values for the slots filled with NULL values.
     * For instance, if all alternateClasses values outside the range
     * lo..hi-1 are NULL, then an HMM sequenceClassifier should return
     * the ratio running forward-backward on the predictedClasses and
     * alternateClasses, with only the values between lo..hi-1 fixed.
     *
     * @param sequence is a sequence of instances to classify 
     * @param predictedClasses is the classification of the
     * sequence, as given by a call to 'classify'
     * @param alternateClasses is another possible classification of the sequence.
     * @param lo is an index into sequence[] (or equivalently, any of the other array arguments)
     * @param hi is another index into sequence[]
     */
    public double confidence(Instance[] sequence,ClassLabel[] predictedClasses,ClassLabel[] alternateClasses,int lo,int hi);
}

