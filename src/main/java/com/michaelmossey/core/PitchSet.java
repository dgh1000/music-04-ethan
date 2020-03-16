package com.michaelmossey.core;

import java.util.*;
import java.util.stream.*;

public class PitchSet
{
    private List<Integer> pitches;

    public PitchSet(List<Integer> pitches)
    {
        this.pitches = pitches;
    }

    public List<Note> playMelody(double tBeg, double span, double dur)
    {
        List<Note> output = new ArrayList<>();
        double t = tBeg;
        for (int p: pitches)
        {
            Note n = new Note(t, t + dur, p);
            output.add(n);
            t += span;
        }
        return output;
    }
    
    public PitchSet transpose(int semitones)
    {
        List<Integer> newPitches = new ArrayList<>();
        newPitches.addAll(pitches);
        for (int i = 0; i < newPitches.size(); i++) {
            newPitches.set(i, newPitches.get(i) + semitones);
        }
        return new PitchSet(newPitches);
    }

    public PitchSet transpose2(int semitones) 
    {
        List<Integer> newPitches = new ArrayList<>();
        for (int p: pitches)
        {
            newPitches.add(p + semitones);
        }
        return new PitchSet(newPitches);
    }

    public PitchSet transpose3(int semitones) {
        List<Integer> newPitches = pitches.stream()
            .map(i -> i + semitones)
            .collect(Collectors.toList());
        return new PitchSet(newPitches);
    }

}

// amazingPitches
//    --> makeAmazingMelody()          --> makeAmazingChord()
//
// PitchSet moreAmazingPitches = amazingPitches.transpose(5)