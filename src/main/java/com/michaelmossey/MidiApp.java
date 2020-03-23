package com.michaelmossey;

import com.michaelmossey.core.*;
import com.michaelmossey.midi.*;
import com.michaelmossey.util.*;
import java.util.*;

public class MidiApp
{
    public static void piece1() throws Exception
    {
        List<Integer> ps = new ArrayList<>(
            Arrays.asList(
            Pitch.fromString("C#4"),
            Pitch.fromString("E4"),
            Pitch.fromString("G#4")
            ));
        List<Integer> eps = new ArrayList<>();
        eps.addAll(ps);
        eps.addAll(ps);
        eps.addAll(ps);
        eps.addAll(ps);
        PitchSet p = new PitchSet(eps);
        List<Note> notes = p.playMelody(1.0, 0.2, 0.6);
        MidiInterface.openPlayClose(notes);
    }

    public static void piece2() throws Exception{
        List<Integer> ps = new ArrayList<>(
            Arrays.asList(
            Pitch.fromString("C#4"),
            Pitch.fromString("E4"),
            Pitch.fromString("G#4")
            ));
        PitchSet p = new PitchSet(ps);
        PitchSet p2 = p.transpose(12);

        List<Note> notes = p2.playMelody(1.0, 0.2, 0.6);
        MidiInterface.openPlayClose(notes);
    }

    public static void hset1() throws Exception
    {
        List<Integer> ps = new ArrayList<>(
            Arrays.asList(
            Pitch.fromString("C#4"),
            Pitch.fromString("E4"),
            Pitch.fromString("G#4")
            ));
        HSet h1 = new HSet(ps);
        
        HSet h2 = new HSet(ps);

        HSet h3 = h1.concat(h2);
        List<Note> notes = h3.playMelody(1, 0.5, 1, 1);
        MidiInterface.openPlayClose(notes);
    }

    public static void hset2() throws Exception
    {
        List<Integer> ps = new ArrayList<>(
            Arrays.asList(
            Pitch.fromString("C3"),
            Pitch.fromString("D3"),
            Pitch.fromString("E3"),
            Pitch.fromString("F3"),
            Pitch.fromString("G3"),
            Pitch.fromString("A3"),
            Pitch.fromString("B3"),
            Pitch.fromString("C4")
            ));

        HSet h1 = new HSet(ps);
        HSet h2 = h1.concat(h1.transpose(12));
        HSet h3 = h2.concat(h1.transpose(24));
        List<Note> notes = new ArrayList<>();
        notes.addAll(h3.playMelody(1, 0.3, 0.3, 1));
        notes.addAll(h3.playMelody(1.6, 0.3, 0.3, 2));

        MidiInterface.openPlayClose(notes);
    }
}