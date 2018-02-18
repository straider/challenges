PigLatin
========

Simple project to explore TDD, Unit Testing and Integration Testing (using JUnit, Mockito and PowerMockito).
- PigLatiner
- PigLatinerTest
    - apple    -> appleway
    - Apple    -> Appleway
    - hello    -> ellohay
    - Hello    -> Ellohay
    - José     -> Oséjay
    - chest    -> estchay
    - CheEse   -> EEsechay
    - sky      -> sky
    - Sky      -> Sky
    - SKY      -> SKY
    - I        -> Iway
    - a        -> away
    - ""       -> ""
    -          -> ""
    - quiet    -> ietquay
    - half-way -> alfhay-ayway
    - 123      -> 123
    - bAEIOU   -> AEIOUbay
    - aEIOU    -> aEIOUWAY vs. aEIOUway (if not considering last letter case, if vowel)
- PigLatinerSpec (borrowed from BDD, Spock, ... )
    - Mock user input and translate a phrase, word by word
    - PigLatinParser: Mock file source and translate sentences, capitalizing first letter of each sentence

- [Pig Latin](https://en.wikipedia.org/wiki/Pig_Latin)
- [What's the origin of pig Latin?](http://www.straightdope.com/columns/read/2163/whats-the-origin-of-pig-latin)
- [Where did Pig Latin come from?](http://ialwayswondered.jarrettgreen.com/2011/05/25/where-did-pig-latin-come-from/)
- [English to Pig Latin Translator](http://www.snowcrest.net/donnelly/piglatin.html)
- [Useful phrases in Pig Latin](http://www.omniglot.com/language/phrases/piglatin.htm)
- [Algorithm Pig Latin](https://github.com/FreeCodeCamp/FreeCodeCamp/wiki/Algorithm-Pig-Latin)
- [Igpay Atinlay](https://www.codechef.com/problems/CEXP06)
- [Pig Latin](http://web.ics.purdue.edu/~morelanj/RAO/prepare2.html)

# Overview

## Problem Statement

### Rules

### Examples

## Goals & Objectives

- Time each step:
    - Ant
    - Maven, without archetype and with archetype
    - Gradle, without init and with init (not using Lazybones)
    - TDD
    - BDD

# Milestones

- WordManipulator / EnglishWord
    - isEmptyOrNull( word )
    - startsWithVowel( word ) / startsWithConsonant( word )
    - isTitleCase( word )
    - isShout( word ) - all uppercase
    - isHyphenated( word )
    - hyphenate( word1, word2 )
    - concatenate( prefix, word, suffix )
    - cutConsonants( word ) - specific to PigLatin
    - getFirstConsonants( word ): if empty then it *may* start with a vowel, not considering "y" as vowel
    - getFirstVowel( word ): if empty then it *may* mean that is not a word ( if getFirstConsonants() is also empty )
- PigLatinTranslator
    - translateWord( EnglishWord )
    - translateWords( List< EnglishWord > )
    - translateSentence( String ) or translatePhrase( String )
    - translateSentences( List< String > ) or translatePhrases( List< String > ) or translateParagraph( List< String > )

## Without Regular Expressions

## With Regular Expressions
