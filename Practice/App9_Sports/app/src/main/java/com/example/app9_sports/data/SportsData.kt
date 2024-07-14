package com.example.app9_sports.data

import android.util.Log
import com.example.app9_sports.R

class SportsData {
    val sportsData = listOf(
            Sport(
                id = 1,
                Title = "Baseball",
                BasicInfo = "Baseball is a bat-and-ball sport played between two teams of nine players each, taking turns batting and fielding.",
                Description = "Baseball is a bat-and-ball sport played between two teams of nine players each, taking turns batting and fielding. The game occurs over the course of several plays, with each play generally beginning when a player on the fielding team, called the pitcher, throws a ball that a player on the batting team, called the batter, tries to hit with a bat. The objective of the offensive team (batting team) is to hit the ball into the field of play, away from the other team's players, allowing its players to run the bases, having them advance counter-clockwise around four bases to score what are called \"runs\". The objective of the defensive team (referred to as the fielding team) is to prevent batters from becoming runners, and to prevent runners' advance around the bases.[2] A run is scored when a runner legally advances around the bases in order and touches home plate (the place where the player started as a batter).\n" +
                        "\n" +
                        "The initial objective of the batting team is to have a player reach first base safely; this generally occurs either when the batter hits the ball and reaches first base before an opponent retrieves the ball and touches the base, or when the pitcher persists in throwing the ball out of the batter's reach. Players on the batting team who reach first base without being called \"out\" can attempt to advance to subsequent bases as a runner, either immediately or during teammates' turns batting. The fielding team tries to prevent runs by getting batters or runners \"out\", which forces them out of the field of play. The pitcher can get the batter out by throwing three pitches which result in strikes, while fielders can get the batter out by catching a batted ball before it touches the ground, and can get a runner out by tagging them with the ball while the runner is not touching a base.\n" +
                        "\n" +
                        "The opposing teams switch back and forth between batting and fielding; the batting team's turn to bat is over once the fielding team records three outs. One turn batting for each team constitutes an inning. A game is usually composed of nine innings, and the team with the greater number of runs at the end of the game wins. Most games end after the ninth inning, but if scores are tied at that point, extra innings are usually played. Baseball has no game clock, though some competitions feature pace-of-play regulations such as the pitch clock to shorten game time.\n" +
                        "\n" +
                        "Baseball evolved from older bat-and-ball games already being played in England by the mid-18th century. This game was brought by immigrants to North America, where the modern version developed. Baseball's American origins, as well as its reputation as a source of escapism during troubled points in American history such as the American Civil War and the Great Depression, have led the sport to receive the moniker of \"America's Pastime\"; since the late 19th century, it has been unofficially recognized as the national sport of the United States, though in modern times is considered less popular than other sports, such as American football. In addition to North America, baseball is considered the most popular sport in parts of Central and South America, the Caribbean, and East Asia, particularly in Japan, South Korea, and Taiwan.\n" +
                        "\n" +
                        "In Major League Baseball (MLB), the highest level of professional baseball in the United States and Canada, teams are divided into the National League (NL) and American League (AL), each with three divisions: East, West, and Central. The MLB champion is determined by playoffs that culminate in the World Series. The top level of play is similarly split in Japan between the Central and Pacific Leagues and in Cuba between the West League and East League. The World Baseball Classic, organized by the World Baseball Softball Confederation, is the major international competition of the sport and attracts the top national teams from around the world. Baseball was played at the Olympic Games from 1992 to 2008, and was reinstated in 2020.",
                Players = "9",
                Olympics = true,
                image = R.drawable.baseball
            ),
            Sport(
                id = 2,
                Title = "Badminton",
                BasicInfo = "Badminton is a racquet sport played using racquets to hit a shuttlecock across a net.",
                Description = "Badminton is a racquet sport played using racquets to hit a shuttlecock across a net. Although it may be played with larger teams, the most common forms of the game are \"singles\" (with one player per side) and \"doubles\" (with two players per side). Badminton is often played as a casual outdoor activity in a yard or on a beach; formal games are played on a rectangular indoor court. Points are scored by striking the shuttlecock with the racquet and landing it within the other team's half of the court.\n" +
                        "\n" +
                        "Each side may only strike the shuttlecock once before it passes over the net. Play ends once the shuttlecock has struck the floor or ground, or if a fault has been called by the umpire, service judge, or (in their absence) the opposing side.[1]\n" +
                        "\n" +
                        "The shuttlecock is a feathered or (in informal matches) plastic projectile that flies differently from the balls used in many other sports. In particular, the feathers create much higher drag, causing the shuttlecock to decelerate more rapidly. Shuttlecocks also have a high top speed compared to the balls in other racquet sports. The flight of the shuttlecock gives the sport its distinctive nature, and in certain languages, e.g. German, the sport is named by reference to this feature i.e. Federball, literally feather-ball.\n" +
                        "\n" +
                        "The game developed in British India from the earlier game of battledore and shuttlecock. European play came to be dominated by Denmark but the game has become very popular in Asia, with recent competitions dominated by China. In 1992, badminton debuted as a Summer Olympic sport with four events: men's singles, women's singles, men's doubles, and women's doubles;[2] mixed doubles was added four years later. At high levels of play, the sport demands excellent fitness: players require aerobic stamina, agility, strength, speed, and precision. It is also a technical sport, requiring good motor coordination and the development of sophisticated racquet movements involving much greater flexibility in the wrist than some other racquet sports.",
                Players = "1",
                Olympics = true,
                R.drawable.badminton
            ),
            Sport(
                id = 3,
                Title = "Basketball",
                BasicInfo = "Basketball is a team sport in which two teams, most commonly of five players each.",
                Description = "Basketball is a team sport in which two teams, most commonly of five players each, opposing one another on a rectangular court, compete with the primary objective of shooting a basketball (approximately 9.4 inches (24 cm) in diameter) through the defender's hoop (a basket 18 inches (46 cm) in diameter mounted 10 feet (3.048 m) high to a backboard at each end of the court), while preventing the opposing team from shooting through their own hoop. A field goal is worth two points, unless made from behind the three-point line, when it is worth three. After a foul, timed play stops and the player fouled or designated to shoot a technical foul is given one, two or three one-point free throws. The team with the most points at the end of the game wins, but if regulation play expires with the score tied, an additional period of play (overtime) is mandated.\n" +
                        "\n" +
                        "Players advance the ball by bouncing it while walking or running (dribbling) or by passing it to a teammate, both of which require considerable skill. On offense, players may use a variety of shots – the layup, the jump shot, or a dunk; on defense, they may steal the ball from a dribbler, intercept passes, or block shots; either offense or defense may collect a rebound, that is, a missed shot that bounces from rim or backboard. It is a violation to lift or drag one's pivot foot without dribbling the ball, to carry it, or to hold the ball with both hands then resume dribbling.\n" +
                        "\n" +
                        "The five players on each side fall into five playing positions. The tallest player is usually the center, the second-tallest and strongest is the power forward, a slightly shorter but more agile player is the small forward, and the shortest players or the best ball handlers are the shooting guard and the point guard, who implement the coach's game plan by managing the execution of offensive and defensive plays (player positioning). Informally, players may play three-on-three, two-on-two, and one-on-one.\n" +
                        "\n" +
                        "Invented in 1891 by Canadian-American gym teacher James Naismith in Springfield, Massachusetts, in the United States, basketball has evolved to become one of the world's most popular and widely viewed sports.[1][2] The National Basketball Association (NBA) is the most significant professional basketball league in the world in terms of popularity, salaries, talent, and level of competition[3][4] (drawing most of its talent from U.S. college basketball). Outside North America, the top clubs from national leagues qualify to continental championships such as the EuroLeague and the Basketball Champions League Americas. The FIBA Basketball World Cup and Men's Olympic Basketball Tournament are the major international events of the sport and attract top national teams from around the world. Each continent hosts regional competitions for national teams, like EuroBasket and FIBA AmeriCup.\n" +
                        "\n" +
                        "The FIBA Women's Basketball World Cup and Women's Olympic Basketball Tournament feature top national teams from continental championships. The main North American league is the WNBA (NCAA Women's Division I Basketball Championship is also popular), whereas the strongest European clubs participate in the EuroLeague Women.",
                Players = "5",
                Olympics = true,
                image = R.drawable.basketball
            ),
            Sport(
                id = 4,
                Title = "Bowling",
                BasicInfo = "Bowling is a target sport and recreational activity in which a player rolls a ball toward pins (in pin bowling) or another target (in target bowling).",
                Description = "Bowling is a target sport and recreational activity in which a player rolls a ball toward pins (in pin bowling) or another target (in target bowling). The term bowling usually refers to pin bowling (most commonly ten-pin bowling), though in the United Kingdom and Commonwealth countries, bowling could also refer to target bowling, such as lawn bowls.\n" +
                        "\n" +
                        "In pin bowling, the goal is to knock over pins on a long playing surface known as a lane. Lanes have a wood or synthetic surface onto which protective lubricating oil is applied in different specified oil patterns that affect ball motion. A strike is achieved when all the pins are knocked down on the first roll, and a spare is achieved if all the pins are knocked over on a second roll. Common types of pin bowling include ten-pin, candlepin, duckpin, nine-pin, and five-pin. The historical game skittles is the forerunner of modern pin bowling.\n" +
                        "\n" +
                        "In target bowling, the aim is usually to get the ball as close to a mark as possible. The surface in target bowling may be grass, gravel, or synthetic.[1] Lawn bowls, bocce, carpet bowls, pétanque, and boules may have both indoor and outdoor varieties. Curling is also related to bowls.\n" +
                        "\n" +
                        "Bowling is played by 120 million people in more than 90 countries (including 70 million people in the United States alone).",
                Players = "1",
                Olympics = false,
                image = R.drawable.bowling
            ),
            Sport(
                id = 5,
                Title = "Cycling",
                BasicInfo = "Cycling, also known as bicycling or biking, is the activity of riding a bicycle or other type of cycle.",
                Description = "In many countries, the most commonly used vehicle for road transport is a utility bicycle. These have frames with relaxed geometry, protecting the rider from shocks of the road and easing steering at low speeds. Utility bicycles tend to be equipped with accessories such as mudguards, pannier racks and lights, which extends their usefulness on a daily basis. Since the bicycle is so effective as a means of transportation, various companies have developed methods of carrying anything from the weekly shop to children on bicycles. Certain countries rely heavily on bicycles and their culture has developed around the bicycle as a primary form of transport. In Europe, Denmark and the Netherlands have the most bicycles per capita and most often use bicycles for everyday transport.[7][8]\n" +
                        "\n" +
                        "Road bikes tend to have a more upright shape and a shorter wheelbase, which make the bike more mobile but harder to ride slowly. The design, coupled with low or dropped handlebars, requires the rider to bend forward more, making use of stronger muscles (particularly the gluteus maximus) and reducing air resistance at high speed.\n" +
                        "\n" +
                        "Road bikes are designed for speed and efficiency on paved roads. They are characterized by their lightweight frames, skinny tires, drop handlebars, and narrow saddles. Road bikes are ideal for racing, long-distance riding, and fitness training.\n" +
                        "\n" +
                        "Other common types of bikes include gravel bikes, designed for use on gravel roads or trails, but with the ability to ride well on pavement, mountain bikes which are designed for more rugged, undulating terrain, and e-bikes which provide some level of motorized assist for the rider. There are additional variations of bikes and types of biking as well.[9]\n" +
                        "\n" +
                        "The price of a new bicycle can range from US\$50 to more than US\$20,000 (the highest priced bike in the world is the custom Madone by Damien Hirst, sold at US\$500,000[10]),[11] depending on quality, type and weight (the most exotic road bicycles can weigh as little as 3.2 kg (7 lb)[12]). However, UCI regulations stipulate a legal race bike cannot weigh less than 6.8 kg (14.99 lbs). Being measured for a bike and taking it for a test ride are recommended before buying.\n" +
                        "\n" +
                        "The drivetrain components of the bike should also be considered. A middle grade dérailleur is sufficient for a beginner, although many utility bikes are equipped with hub gears. If the rider plans a significant amount of hillclimbing, a triple-chainrings crankset gear system may be preferred. Otherwise, the relatively lighter, simpler, and less expensive double chainring is preferred, even on high-end race bikes. Much simpler fixed wheel bikes are also available.\n" +
                        "\n" +
                        "Many road bikes, along with mountain bikes, include clipless pedals to which special shoes attach, via a cleat, enabling the rider to pull on the pedals as well as push. Other possible accessories for the bicycle include front and rear lights, bells or horns, child carrying seats, cycling computers with GPS, locks, bar tape, fenders (mud-guards), baggage racks, baggage carriers and pannier bags, water bottles and bottle cages.\n" +
                        "\n" +
                        "For basic maintenance and repairs cyclists can carry a pump (or a CO2 cartridge), a puncture repair kit, a spare inner tube, and tire levers and a set of allen keys. Cycling can be more efficient and comfortable with special shoes, gloves, and shorts. In wet weather, riding can be more tolerable with waterproof clothes, such as cape, jacket, trousers (pants) and overshoes and high-visibility clothing is advisable to reduce the risk from motor vehicle users.\n" +
                        "\n" +
                        "Items legally required in some jurisdictions, or voluntarily adopted for safety reasons, include bicycle helmets,[13] generator or battery operated lights, reflectors, and audible signalling devices such as a bell or horn. Extras include studded tires and a bicycle computer.\n" +
                        "\n" +
                        "Bikes can also be heavily customized, with different seat designs and handle bars, for example. Bicycle Gears can also be customized to better suit the rider's strength in relation to the terrain.",
                Players = "1",
                Olympics = true,
                image = R.drawable.cycling
            ),
            Sport(
                id = 6,
                Title = "Golf",
                BasicInfo = "Golf is a club-and-ball sport in which players use various clubs to hit a ball into a series of holes on a course in as few strokes as possible.",
                Description = "Golf is a club-and-ball sport in which players use various clubs to hit a ball into a series of holes on a course in as few strokes as possible.\n" +
                        "\n" +
                        "Golf, unlike most ball games, cannot and does not use a standardized playing area, and coping with the varied terrains encountered on different courses is a key part of the game. Courses typically have either 9 or 18 holes, regions of terrain that each contain a cup, the hole that receives the ball. Each hole on a course contains a teeing ground to start from, and a putting green containing the cup. There are several standard forms of terrain between the tee and the green, such as the fairway, rough (tall grass), and various hazards such as water, rocks, or sand-filled bunkers. Each hole on a course is unique in its specific layout.\n" +
                        "\n" +
                        "Golf is played for the lowest number of strokes by an individual, known as stroke play, or the lowest score on the most individual holes in a complete round by an individual or team, known as match play. Stroke play is the most commonly seen format at all levels, especially at the elite level.\n" +
                        "\n" +
                        "The modern game of golf originated in 15th century Scotland. The 18-hole round was created at the Old Course at St Andrews in 1764. Golf's first major, and the world's oldest golf tournament, is The Open Championship, also known as the British Open, which was first played in 1860 at the Prestwick Golf Club in Ayrshire, Scotland. This is one of the four major championships in men's professional golf, the other three being played in the United States: The Masters, the U.S. Open, and the PGA Championship." +
                        "Every round of golf is based on playing a number of holes in a given order. A \"round\" typically consists of 18 holes that are played in the order determined by the course layout. Each hole is played once in the round on a standard course of 18 holes. The game can be played by any number of people, although a typical group will have 1–4 people playing the round. The typical amount of time required for pace of play is about two hours for a 9-hole round and four hours for an 18-hole round.[22]\n" +
                        "\n" +
                        "Playing a hole on a golf course is initiated by putting a ball into play by striking it with a club on the teeing ground (also called the tee box, or simply the tee). For this first shot on each hole, it is allowed but not required for the golfer to place the ball on a tee prior to striking it. A tee is a small peg that can be used to elevate the ball slightly above the ground up to a few centimetres high. Tees are commonly made of wood but may be constructed of any material, including plastic. Traditionally, golfers used mounds of sand to elevate the ball, and containers of sand were provided for the purpose.[23][24] A few courses still require sand to be used instead of peg tees, to reduce litter and reduce damage to the teeing ground. Tees help reduce the interference of the ground or grass on the movement of the club making the ball easier to hit by elevating the ball from the playing surface.[25]\n" +
                        "\n" +
                        "When the initial shot on a hole is intended to move the ball a long distance, typically more than 225 yards (210 m), the shot is commonly called a \"drive\" and is generally made with a long-shafted, large-headed wood club called a \"driver\".[26] Shorter holes may be initiated with other clubs, such as higher-numbered woods or irons. Once the ball comes to rest, the golfer strikes it again as many times as necessary using shots that are variously known as a \"lay-up\", an \"approach\", a \"pitch\", or a \"chip\", until the ball reaches the green, where the golfer then \"putts\" the ball into the hole (commonly called \"sinking the putt\" or \"holing out\"). The goal of getting the ball into the hole (\"holing\" the ball) in as few strokes as possible may be impeded by obstacles such as areas of longer grass called \"rough\" (usually found alongside fairways), which both slows any ball that contacts it and makes it harder to advance a ball that has stopped on it; \"doglegs\", which are changes in the direction of the fairway that often require shorter shots to play around them; bunkers (or sand traps); and water hazards such as ponds or streams.[17]\n" +
                        "\n" +
                        "In stroke play competitions each player plays their ball until it is holed no matter how many strokes that may take.[27][needs copy edit] In match play it is acceptable to simply pick up one's ball and \"surrender the hole\" after enough strokes have been made by a player that it is mathematically impossible for the player to win the hole.[28] It is also acceptable in informal stroke play to surrender the hole after hitting three strokes more than the \"par\" rating of the hole (a \"triple bogey\" – see below); while technically a violation of Rule 3–2, this practice speeds play as a courtesy to others, and avoids \"runaway scores\" and excessive frustration.[29] Alternatively, in competition, the committee may designate a maximum score possible for a hole for the same reasons, while formalizing the surrender or \"pick-up\" rule.[30]\n" +
                        "\n" +
                        "The total distance from the first teeing ground to the 18th green can be quite long; total yardages \"through the green\" can be in excess of 7,000 yards (6,400 m), and when adding in the travel distance between the green of one hole and the tee of the next, even skilled players may easily travel 5 miles (8.0 km) or more during a round. At some courses, gas or electric golf carts are used to travel between shots, which can speed-up play and allows participation by individuals unable to walk a whole round. On other courses players generally walk the course, either carrying their bag using a shoulder strap or using a \"golf trolley\" for their bag. These trolleys may or may not be battery assisted. At many amateur tournaments including U.S. high school and college play, players are required to walk and to carry their own bags, but at the professional and top amateur level, as well as at high-level private clubs, players may be accompanied by caddies, who carry and manage the players' equipment and who are allowed by the rules to give advice on the play of the course.[31]",
                Players = "1",
                Olympics = true,
                image = R.drawable.golf
            )
        )

    fun getSport(id: Int): Sport? {
        return sportsData.firstOrNull { it.id == id}
    }

    val default = Sport(Title = "Not Exists")
}