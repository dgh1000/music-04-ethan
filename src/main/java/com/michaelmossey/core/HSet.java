package com.michaelmossey.core;

import java.util.*;
import java.util.stream.*;

public class HSet
{
    private List<Integer> pitches;

    public HSet(List<Integer> pitches)
    {
        this.pitches = pitches;
    }

    public List<Note> playMelody(double tBeg, double span, double dur, int channel)
    {
        List<Note> output = new ArrayList<>();
        double t = tBeg;
        for (int p: pitches)
        {
            Note n = new Note(t, t + dur, p, channel);
            output.add(n);
            t += span;
        }
        return output;
    }

    public HSet concat(HSet other)
    {
        List<Integer> newPitches = new ArrayList<>(pitches);
        newPitches.addAll(other.pitches);
        return new HSet(newPitches);
    }

    public HSet transpose(int semitones)
    {
        List<Integer> newPitches = pitches.stream()
            .map(i -> i + semitones)
            .collect(Collectors.toList());
        return new HSet(newPitches);
    }
}