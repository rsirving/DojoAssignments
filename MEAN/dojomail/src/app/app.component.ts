import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  emails = [
    {email: 'tmiller@gmail.com',
    importance: false,
    subject: "please call",
    content: "Oh hey, this is Tom Miller from city hall, and just wanted to get in touch with you about some things you were sayin' the other day at the ole town meeting. Uh, so, give me a call back here, 'fore too long. My number is 875-7112, and I'll, talk to you then. Thanks a lot. Bye."
    },
    {email: 'tmiller@gmail.com',
    importance: false,
    subject: "bears",
    content: "Oh hey, it's Tom, Tom Miller, again, from city hall, and just wanted to get back in touch with you about some things we talked about the other day, and I've been thinking about what you were saying about the pest problem with the coyotes, and I really do think bears is the way we wanna go. So let me know when we can talk about that, get some plans laid out. You know my number is 875-7112, and we'll talk more then, thanks a lot. Bye."
    },
    {email: 'tmiller@gmail.com',
    importance: false,
    subject: "bear problems?",
    content: "Hey it's Tom Miller again, just wanted to let you know, bears is going great. We haven't seen any coyotes around in a little while, so that's good. Do have one question though, about one of the bears getting a little close to town, one of the gals in town is a little freaked out about it. So we can talk about that, and get some of these details ironed out, I think this is gonna be real great. Okay thanks a lot, oh yeah, number is 875-7112, and we'll talk then. Thanks a lot, bye."
    },
    {email: 'tmiller@gmail.com',
    importance: true,
    subject: "too many bears",
    content: "Okay listen there are too many bears in town now. A little boy got attacked just the other day, in the street, he was with his mom. He got attacked by one of the bears, okay, there are too many bears now. I need you to call me please as soon as you can, so we can do something about this. Okay thanks, oh wait, 875-7112, okay call me soon, thanks, bye."
    },
    {email: 'tmiller@gmail.com',
    importance: true,
    subject: "bears help",
    content: "Okay listen there is a bear outside of my house, okay. My neighbor just got fucking eated by a bear. Okay there are bears on the streets, there are bears in peoples' homes, okay, we gotta do something about this. There's, I can't get outside, okay, my kids are at school, I can't get to my kids. Okay there is a bear on my car, why can't oh god (bear attack sounds), oh lord there's a bear in the house, oh, 875-7112 call me please (dial tone)."
    }
  ]
}
