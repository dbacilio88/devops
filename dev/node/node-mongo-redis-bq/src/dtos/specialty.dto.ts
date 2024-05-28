import { AutoMap } from "@automapper/classes";
import { ApiProperty } from "@nestjs/swagger";
import { IsString } from "class-validator";
import { DtoBase } from "src/components/base/dto.base";

export class SpecialtyDto extends DtoBase {

    @IsString()
    @ApiProperty({
        description: 'code',
        example: 'code',
        nullable: true,
        uniqueItems: true,
        maxLength: 20,
    })
    @AutoMap()
    code: string

    @IsString()
    @ApiProperty({
        description: 'name',
        example: 'name',
        nullable: true,
        uniqueItems: true,
        maxLength: 20,
    })
    @AutoMap()
    name: string


    @IsString()
    @ApiProperty({
        description: 'decription',
        example: 'decription',
        nullable: true,
        uniqueItems: true,
        maxLength: 100,
    })
    @AutoMap()
    description: string

}